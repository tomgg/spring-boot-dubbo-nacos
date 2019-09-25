package cn.yase.api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import cn.yase.dto.UserDTO;
import cn.yase.param.UserParam;

/**
 * @author yase
 * @since 2019/9/24 下午5:08
 */
@Path("sayHello")
public interface SayHello {

    @POST
    @Path("/user")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    UserDTO sayHello(UserParam param);
}
