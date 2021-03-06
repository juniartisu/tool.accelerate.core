/*******************************************************************************
 * Copyright (c) 2016 IBM Corp.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.ibm.liberty.starter.api.v1;

import com.ibm.liberty.starter.StarterUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.io.FileUtils;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.IOException;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("v1/workspace")
@Api(value = "Workspace Identifier")
public class LibertyStarterWorkspace {

	private static final Logger log = Logger.getLogger(LibertyStarterWorkspace.class.getName());
	
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_PLAIN)
	// Swagger annotations
	@ApiOperation(value = "Retrieve a unique workspace identifier", httpMethod = "GET", notes = "Get a unique workspace to store files.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully created a unique workspace identifier") })
	public Response workspace() throws IOException {
		String uuid = StarterUtil.createCleanWorkspace();
		return Response.ok(uuid, MediaType.TEXT_PLAIN).build();
	}

}
