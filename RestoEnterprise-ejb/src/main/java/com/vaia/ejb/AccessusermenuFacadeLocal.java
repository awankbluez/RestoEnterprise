/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vaia.ejb;

import com.vaia.entity.Accessusermenu;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author awank
 */
@Local
public interface AccessusermenuFacadeLocal {

   void create(Accessusermenu accessusermenu);

   void edit(Accessusermenu accessusermenu);

   void remove(Accessusermenu accessusermenu);

   Accessusermenu find(Object id);

   List<Accessusermenu> findAll();

   List<Accessusermenu> findRange(int[] range);

   int count();

}
