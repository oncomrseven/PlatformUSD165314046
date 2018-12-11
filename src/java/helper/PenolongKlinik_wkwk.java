/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Klinik;
import pojos.Location;
import util.ApaanHibernateUtil;

/**
 *
 * @author USER
 */
public class PenolongKlinik_wkwk {

    public List<Klinik> getKlinik(){
        Session session = util.ApaanHibernateUtil.getSessionFactory().openSession();
        
        Transaction tx = session.beginTransaction();
        List<Klinik> klinik = null;
        Query q = session.createQuery("from Klinik k");
        klinik = q.list();
        tx.commit();
        session.close();
        return klinik;
    }
//    public static String toJson() {
//        PenolongKlinik_wkwk helper = new PenolongKlinik_wkwk();
//        List<Klinik> list = helper.bacaSemuaKlinik();
//        String result = "[";
//        for (int i = 0; i < list.size(); i++) {
//            if (i < list.size() - 1) {
//                result = result + list.get(i).toJson() + ",\n";
//            } else {
//                result = result + list.get(i).toJson() + "\n";
//            }
//        }
//        result = result + "]";
//        return result;
//    }
//    
    public void addNewKlinik(
            String idKlinik,
            String nama,
            String spesialis) {
        Session session = ApaanHibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Klinik klinik = new Klinik(idKlinik, nama, spesialis);
        session.saveOrUpdate(klinik);
        transaction.commit();
        session.close();
    }

    
    
}
