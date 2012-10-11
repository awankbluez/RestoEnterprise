/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vaia.ejb;

import com.vaia.entity.Mastercity;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author awank
 */
@Local
public interface MastercityFacadeLocal {

   void create(Mastercity mastercity);

   void edit(Mastercity mastercity);

   void remove(Mastercity mastercity);

   Mastercity find(Object id);

   List<Mastercity> findAll();

   List<Mastercity> findRange(int[] range);

   int count();

}
