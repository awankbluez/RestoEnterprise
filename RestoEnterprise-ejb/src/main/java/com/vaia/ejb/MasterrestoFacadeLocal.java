/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vaia.ejb;

import com.vaia.entity.Masterresto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author awank
 */
@Local
public interface MasterrestoFacadeLocal {

   void create(Masterresto masterresto);

   void edit(Masterresto masterresto);

   void remove(Masterresto masterresto);

   Masterresto find(Object id);

   List<Masterresto> findAll();

   List<Masterresto> findRange(int[] range);

   int count();

}
