package cn.yase.api;


import cn.yase.dto.UserDTO;
import cn.yase.param.UserParam;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
