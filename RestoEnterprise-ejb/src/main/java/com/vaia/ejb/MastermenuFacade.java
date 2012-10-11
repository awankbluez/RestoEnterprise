/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vaia.ejb;

import com.vaia.entity.Mastermenu;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author awank
 */
@Stateless
public class MastermenuFacade extends AbstractFacade<Mastermenu> implements MastermenuFacadeLocal {
   @PersistenceContext(unitName = "com.vaia_TestEnterprise-ejb_ejb_1.0-SNAPSHOTPU")
   private EntityManager em;

   @Override
   protected EntityManager getEntityManager() {
      return em;
   }

   public MastermenuFacade() {
      super(Mastermenu.class);
   }

}
