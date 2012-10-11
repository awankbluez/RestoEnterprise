/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vaia.ejb;

import com.vaia.entity.Accessuserresto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author awank
 */
@Local
public interface AccessuserrestoFacadeLocal {

   void create(Accessuserresto accessuserresto);

   void edit(Accessuserresto accessuserresto);

   void remove(Accessuserresto accessuserresto);

   Accessuserresto find(Object id);

   List<Accessuserresto> findAll();

   List<Accessuserresto> findRange(int[] range);

   int count();

}
