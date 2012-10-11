/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vaia.ejb;

import com.vaia.entity.Masteruser;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author awank
 */
@Local
public interface MasteruserFacadeLocal {

   void create(Masteruser masteruser);

   void edit(Masteruser masteruser);

   void remove(Masteruser masteruser);

   Masteruser find(Object id);

   List<Masteruser> findAll();

   List<Masteruser> findRange(int[] range);

   int count();

}
