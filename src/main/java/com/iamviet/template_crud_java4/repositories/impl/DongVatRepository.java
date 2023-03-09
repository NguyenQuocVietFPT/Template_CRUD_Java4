package com.iamviet.template_crud_java4.repositories.impl;

import com.iamviet.template_crud_java4.entities.DongVat;
import com.iamviet.template_crud_java4.repositories.IDongVatrRepository;
import com.iamviet.template_crud_java4.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class DongVatRepository implements IDongVatrRepository {

    @Override
    public List<DongVat> getAll() {

        List<DongVat> dongVats  = new ArrayList<>();
        /*Khởi tạo session*/
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            /*Khởi tạo query select * from DongVat*/
            Query q = session.createQuery("from DongVat ");

            /*Gán dữ liệu lấy từ database vào list dongVats*/
            dongVats = q.getResultList();

        }catch (Exception e) {
            dongVats = null;
        }

        /*Trả về list dongVats*/
        return dongVats;
    }

    @Override
    public DongVat addNew(DongVat dv) {
        /*Khởi tạo transaction để thực hiện truy vấn*/
        Transaction transaction = null;
        /*Khởi tạo session*/
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {

            /*Gán transaction bằng session.getTransaction()*/
            transaction = session.getTransaction();
            /*Bắt đầu 1 transaction*/
            transaction.begin();
            /*Lưu dữ liệu mới vào database temp*/
            session.persist(dv);
            /*Thành công -> Lưu thành công vào database gốc */
            transaction.commit();

        } catch (Exception e) {

            if (transaction != null) {
                dv = null;
                /*Thất bại -> Không lưu dữ liệu mới vào database gốc */
                transaction.rollback();

            }
        }
        return dv;
    }

    @Override
    public DongVat getById(Integer id) {

        DongVat dv = null;
        /*Khởi tạo session*/
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            /*Khởi tạo query select dv from DongVat as dv where as.id = ?*/
            Query q = session.createQuery("from DongVat where id = :id");
            /*Gán tham số id*/
            q.setParameter("id", id);
            /*Gán biến dv bằng hàm q.getSingleResult()*/
            dv = (DongVat) q.getSingleResult();

        } catch (Exception e) {
            dv = null;
        }
        /*Trả về biến dv*/
        return dv;
    }

    @Override
    public void updateById(DongVat dv) {

        /*Khởi tạo transaction để thực hiện truy vấn*/
        Transaction transaction = null;
        /*Khởi tạo session*/
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {

            /*Gán transaction bằng session.getTransaction()*/
            transaction = session.getTransaction();
            /*Bắt đầu 1 transaction*/
            transaction.begin();
            /*2 hàm thay đổi*/
            /*Hàm 1*/ session.update(dv);
            /*Hàm 2 session.update(dv);*/
            /*Thành công -> Thay đổi thông tin mới vào database gốc */
            transaction.commit();

        } catch (Exception e) {

            if (transaction != null) {

                /*Thành công -> Giữ nguyên thông tin cũ */
                transaction.rollback();

            }
        }
    }

    @Override
    public void deleteById(DongVat dv) {

        /*Khởi tạo transaction để thực hiện truy vấn*/
        Transaction transaction = null;
        /*Khởi tạo session*/
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {

            /*Gán transaction bằng session.getTransaction()*/
            transaction = session.getTransaction();
            /*Bắt đầu 1 transaction*/
            transaction.begin();
            session.delete(dv);
            /*Thành công -> Xóa dữ liệu có trong database gốc */
            transaction.commit();

        } catch (Exception e) {

            if (transaction != null) {
                /*Thành công -> Giữ nguyên dữ liệu có trong database gốc */
                transaction.rollback();
            }
        }

    }
}
