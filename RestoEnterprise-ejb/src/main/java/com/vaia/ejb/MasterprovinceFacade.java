/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vaia.ejb;

import com.vaia.entity.Masterprovince;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author awank
 */
@Stateless
public class MasterprovinceFacade extends AbstractFacade<Masterprovince> implements MasterprovinceFacadeLocal {
   @PersistenceContext(unitName = "com.vaia_TestEnterprise-ejb_ejb_1.0-SNAPSHOTPU")
   private EntityManager em;

   @Override
   protected EntityManager getEntityManager() {
      return em;
   }

   public MasterprovinceFacade() {
      super(Masterprovince.class);
   }

}
