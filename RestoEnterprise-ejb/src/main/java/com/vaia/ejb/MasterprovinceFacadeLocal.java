/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vaia.ejb;

import com.vaia.entity.Masterprovince;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author awank
 */
@Local
public interface MasterprovinceFacadeLocal {

   void create(Masterprovince masterprovince);

   void edit(Masterprovince masterprovince);

   void remove(Masterprovince masterprovince);

   Masterprovince find(Object id);

   List<Masterprovince> findAll();

   List<Masterprovince> findRange(int[] range);

   int count();

}
