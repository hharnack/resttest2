/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author 553185
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(filters.NewCrossOriginResourceSharingFilter.class);
        resources.add(rest.Base.class);
        resources.add(rest.BookBoarding.class);
        resources.add(rest.BookDaycare.class);
        resources.add(rest.BookTraining.class);
        resources.add(rest.CalculateCost.class);
        resources.add(rest.ChangePassword.class);
        resources.add(rest.CheckAccount.class);
        resources.add(rest.CheckEditCustomer.class);
        resources.add(rest.DeleteDog.class);
        resources.add(rest.GetDog.class);
        resources.add(rest.Login.class);
        resources.add(rest.RegisterAccount.class);
        resources.add(rest.RegisterDog.class);
        resources.add(rest.RetrieveDogs.class);
        resources.add(rest.RetrieveUser.class);
        resources.add(rest.UpdateAccount.class);
        resources.add(rest.UpdateDog.class);
    }
    
}
