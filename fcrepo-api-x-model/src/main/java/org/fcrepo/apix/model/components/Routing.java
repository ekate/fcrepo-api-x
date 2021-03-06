/*
 * Licensed to DuraSpace under one or more contributor license agreements.
 * See the NOTICE file distributed with this work for additional information
 * regarding copyright ownership.
 *
 * DuraSpace licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except in
 * compliance with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.fcrepo.apix.model.components;

import java.net.URI;

import org.fcrepo.apix.model.Extension.ServiceExposureSpec;

/**
 * Routing component.
 *
 * @author apb@jhu.edu
 */
public interface Routing {

    /** Fedora repository resource relevant to a resource-scoped exposed service */
    public static final String HTTP_HEADER_REPOSITORY_RESOURCE_URI = "Apix-Ldp-Resource";

    /** API-X proxied repository resource relevant to a resource-scoped exposed service */
    public static final String HTTP_HEADER_APIX_RESOURCE_URI = "Apix-Resource";

    /** Fedora repository resource path relevant to a resource-scoped exposed service */
    public static final String HTTP_HEADER_REPOSITORY_RESOURCE_PATH = "Apix-Ldp-Resource-Path";

    /** Repository or resource-scoped exposed service URI */
    public static final String HTTP_HEADER_EXPOSED_SERVICE_URI = "Apix-Exposed-Uri";

    /** Repository root (baseURI) */
    public static final String HTTP_HEADER_REPOSITORY_ROOT_URI = "Apix-Ldp-Root";

    /** API-X proxied repository root (baseURI) */
    public static final String HTTP_HEADER_APIX_ROOT_URI = "Apix-Root";

    /**
     * Get the endpoint for the service exposed by the given extension on the given resource.
     *
     * @param spec specification for exposing a service
     * @param onResource the resource on which the service is exposed.
     * @return URI of exposed service, null if not applicable.
     */
    public URI endpointFor(ServiceExposureSpec spec, URI onResource);

    /**
     * Get the endpoint for the service exposed by the given extension on the given resource path.
     *
     * @param spec specification for exposing a service
     * @param path path of the resource on which the service is exposed.
     * @return URI of exposed service, null if not applicable.
     */
    public URI endpointFor(ServiceExposureSpec spec, String path);

    /**
     * Get the endpoint for the service doc of a given resource.
     *
     * @param resource the resource
     * @return URI that resolves to the service document.
     */
    public URI serviceDocFor(URI resource);

    /**
     * Get the endpoint for the service doc of a given resource path.
     *
     * @param resourcePath repository resource path
     * @return URI that resolves to the service document.
     */
    public URI serviceDocFor(String resourcePath);

    /**
     * Get the intercept (proxy) URI for a given resource. If it already is a proxy URI, return it unmodified
     *
     * @param resource Fedora resource URI
     * @return URI that routes through the intercept(proxy) endpoint.
     */
    public URI interceptUriFor(URI resource);

    /**
     * Get the non-intercept (non-proxy) URI for the given resource. If the URI already is a non-intercept URI, return
     * it unmodified.
     *
     * @param resource Possibly proxied resource URI
     * @return URI that does not route through the intercept (proxy) endpoint.
     */
    public URI nonProxyURIFor(URI resource);

    /**
     * Get the identifying path compoment for the given fedora resource URI.
     *
     * @param resourceURI the resource URI.
     * @return absolute path of the resource.
     * @throws ResourceNotFoundException if the resource URI is syntactically incorrect (e.g has a different base URI
     *         from the configured Fedora instance, etc).
     */
    public String resourcePath(URI resourceURI);

}
