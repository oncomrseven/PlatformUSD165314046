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
import pojos.Dokter;
import pojos.Klinik;
import util.ApaanHibernateUtil;

/**
 *
 * @author USER
 */
public class PenolongDokter_wkwk {

    public PenolongDokter_wkwk() {
    }
     public List<Dokter> bacaSemuaDokter() {
        List<Dokter> list = null;
        Session session = ApaanHibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Dokter d");
        list = q.list();
        tx.commit();
        session.close();
        return list;

    }

    public static String toJson() {
        PenolongDokter_wkwk helper = new PenolongDokter_wkwk();
        List<Dokter> list = helper.bacaSemuaDokter();
        String result = "[";
        for (int i = 0; i < list.size(); i++) {
            if (i < list.size() - 1) {
                result = result + list.get(i).toJson() + ",\n";
            } else {
                result = result + list.get(i).toJson() + "\n";
            }
        }
        result = result + "]";
        return result;
    }
    
    public void addnewDokter(String nama, String spesialis){
        Session session = ApaanHibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Dokter dokter = new Dokter (nama, spesialis);
        session.saveOrUpdate(dokter);
        transaction.commit();
        session.close();
        
                
    }
    
}
