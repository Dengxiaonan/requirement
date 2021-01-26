package com.xian.requireproject.controller.cangku;

import com.xian.requireproject.common.remind.JsonResult;
import com.xian.requireproject.repository.cangku.entity.CangKu;
import com.xian.requireproject.service.cangku.CangKuService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/仓库管理")
@Api(value = "/group",tags = {"角色相关接口"})
public class CangKuController {
    @Resource
    private CangKuService cangKuService;

    @RequestMapping("/getAll")
    public List<CangKu> getAll(){
       return cangKuService.getAll();
}
   @RequestMapping("/addCang")
    public JsonResult addCang(@RequestBody CangKu cangKu){
       cangKuService.addCang(cangKu);
       return JsonResult.success("OK");
            }

   @RequestMapping("/delCang")
    public JsonResult delCang(String uuid){
        cangKuService.delCang(uuid);
        return JsonResult.success("OK");
        }
@RequestMapping("/updateCang")
    public JsonResult updateCang(@RequestBody CangKu cangKu){
        cangKuService.updateCang(cangKu);
        return JsonResult.success("OK");
}
}
