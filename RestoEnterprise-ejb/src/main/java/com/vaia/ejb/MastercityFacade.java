/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vaia.ejb;

import com.vaia.entity.Mastercity;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author awank
 */
@Stateless
public class MastercityFacade extends AbstractFacade<Mastercity> implements MastercityFacadeLocal {
   @PersistenceContext(unitName = "com.vaia_TestEnterprise-ejb_ejb_1.0-SNAPSHOTPU")
   private EntityManager em;

   @Override
   protected EntityManager getEntityManager() {
      return em;
   }

   public MastercityFacade() {
      super(Mastercity.class);
   }

}
