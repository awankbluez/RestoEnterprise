/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vaia.ejb;

import com.vaia.entity.Masterposition;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author awank
 */
@Local
public interface MasterpositionFacadeLocal {

   void create(Masterposition masterposition);

   void edit(Masterposition masterposition);

   void remove(Masterposition masterposition);

   Masterposition find(Object id);

   List<Masterposition> findAll();

   List<Masterposition> findRange(int[] range);

   int count();

}
