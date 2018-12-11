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
import pojos.Location;
import util.ApaanHibernateUtil;

/**
 *
 * @author USER
 */
public class PenolongLokasi_wkwk {

    public PenolongLokasi_wkwk() {
    }

    public List<Location> bacaSemuaLokasi() {
        List<Location> list = null;
        Session session = ApaanHibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Location l");
        list = q.list();
        tx.commit();
        session.close();
        return list;

    }

    public static String toJson() {
        PenolongLokasi_wkwk helper = new PenolongLokasi_wkwk();
        List<Location> list = helper.bacaSemuaLokasi();
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
}
