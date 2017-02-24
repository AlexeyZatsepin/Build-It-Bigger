/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.study.backend.joker;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.study.backend.joker.beans.Bean;

import javax.inject.Named;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "jokesApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "joker.backend.study.com",
                ownerName = "joker.backend.study.com"
        )
)
public class Endpoint {

    /**
     * A simple endpoint method that takes a name and says Hi back
     */
    @ApiMethod(name = "sayHi")
    public Bean sayHi(@Named("name") String name) {
        Bean response = new Bean();
        response.setData("Hi, " + name);

        return response;
    }
    @ApiMethod(name = "getJoke", httpMethod = ApiMethod.HttpMethod.GET)
    public Bean getJoke() {
        return Bean.buildJoke();
    }

}
