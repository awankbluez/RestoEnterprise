/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vaia.ejb;

import com.vaia.entity.Mastermenu;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author awank
 */
@Local
public interface MastermenuFacadeLocal {

   void create(Mastermenu mastermenu);

   void edit(Mastermenu mastermenu);

   void remove(Mastermenu mastermenu);

   Mastermenu find(Object id);

   List<Mastermenu> findAll();

   List<Mastermenu> findRange(int[] range);

   int count();

}
