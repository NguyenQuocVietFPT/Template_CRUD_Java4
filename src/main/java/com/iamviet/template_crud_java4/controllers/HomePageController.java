package com.iamviet.template_crud_java4.controllers;


import com.iamviet.template_crud_java4.repositories.IDongVatrRepository;
import com.iamviet.template_crud_java4.repositories.impl.DongVatRepository;
import com.iamviet.template_crud_java4.entities.DongVat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(value = {
        "/dong-vat",                   /*[GET]: /dong-vat */
        "/dong-vat/hien-thi",          /*[GET]: /dong-vat/hien-thi */
        "/dong-vat/them",              /*[GET]: /dong-vat/them */
        "/dong-vat/update",            /*[GET]: /dong-vat/update */
        "/dong-vat/delete",            /*[DELETE]: /dong-vat/delete */
        "/dong-vat/detail",            /*[GET]: /dong-vat/detail */
        "/dong-vat/add-new",           /*[POST]: /dong-vat/add-new */
        "/dong-vat/update-dongvat",    /*[POST]: /dong-vat/update-dongvat */
})


public class HomePageController extends HttpServlet {


    /*Khởi tạo _dongvatRepo*/
    private IDongVatrRepository _dongvatRepo = new DongVatRepository();

    /*Khởi tạo web*/
    @Override
    public void init() throws ServletException {
        super.init();
    }

    /*Xử lý các [GET] request method*/
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();

        if (url.contains("hien-thi")) {
            this.hienThi(req, resp);
        } else if (url.contains("them")) {
            this.hienThiFormThem(req, resp);
        } else if (url.contains("detail")) {
            this.showDetail(req, resp);
        } else if (url.contains("update")) {
            this.hienThiFormSua(req, resp);
        } else if (url.contains("delete")) {
            this.delete(req, resp);
        }
    }

    /*Xử lý các [POST] request method*/
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String url = req.getRequestURI();
        if (url.contains("add-new")) {
            this.addNew(req, resp);
        } else if (url.contains("update-dongvat")) {
            this.update(req, resp);
        }
    }

    /*Method : hienThi(req,resp)*/
    protected void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<DongVat> dongVats = _dongvatRepo.getAll();
        req.setAttribute("dongVats", dongVats);
        RequestDispatcher rd = req.getRequestDispatcher("/views/list-dongvat.jsp");
        rd.forward(req, resp);
    }

    /*Method : hienThiFormThem(req,resp)*/
    protected void hienThiFormThem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        RequestDispatcher rd = req.getRequestDispatcher("/views/add-dongvat.jsp");
        rd.forward(req, resp);
    }

    /*Method : hienThiFormSua(req,resp)*/
    protected void hienThiFormSua(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer id = Integer.valueOf(req.getParameter("id"));
        DongVat dongvat = _dongvatRepo.getById(id);
        req.setAttribute("dongvat", dongvat);
        RequestDispatcher rd = req.getRequestDispatcher("/views/update-dongvat.jsp");
        rd.forward(req, resp);

    }

    /*Method : showDetail(req,resp)*/
    protected void showDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer id = Integer.valueOf(req.getParameter("id"));
        DongVat dongvat = _dongvatRepo.getById(id);
        req.setAttribute("dongvat", dongvat);
        RequestDispatcher rd = req.getRequestDispatcher("/views/detail-dongvat.jsp");
        rd.forward(req, resp);

    }

    /*Method : addNew(req,resp)*/
    protected void addNew(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String ten = req.getParameter("ten");
        Double can_nang = Double.valueOf(req.getParameter("canNang"));
        Boolean gioi_tinh = Boolean.valueOf(req.getParameter("gioiTinh"));
        Integer nam_sinh = Integer.valueOf(req.getParameter("namSinh"));
        DongVat dongVat = new DongVat(ten, can_nang, gioi_tinh, nam_sinh);
        _dongvatRepo.addNew(dongVat);
        resp.sendRedirect("/dong-vat/hien-thi");

    }

    /*Method : update(req,resp)*/
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer id = Integer.valueOf(req.getParameter("id"));
        String ten = req.getParameter("ten");
        Double can_nang = Double.valueOf(req.getParameter("canNang"));
        Boolean gioi_tinh = Boolean.valueOf(req.getParameter("gioiTinh"));
        Integer nam_sinh = Integer.valueOf(req.getParameter("namSinh"));
        DongVat dongVat = new DongVat(id,ten, can_nang, gioi_tinh, nam_sinh);
        _dongvatRepo.updateById(dongVat);
        resp.sendRedirect("/dong-vat/hien-thi");

    }

    /*Method : delete(req,resp)*/
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer id = Integer.valueOf(req.getParameter("id"));
        DongVat dongvat = _dongvatRepo.getById(id);
        _dongvatRepo.deleteById(dongvat);
        resp.sendRedirect("/dong-vat/hien-thi");

    }

    /*Hủy web*/
    @Override
    public void destroy() {
        super.destroy();
    }
}
