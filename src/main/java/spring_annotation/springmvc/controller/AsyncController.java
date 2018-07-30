package spring_annotation.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;
import spring_annotation.springmvc.queue.DefferedQueue;

@Controller
public class AsyncController {

    @ResponseBody
    @RequestMapping("/createOrder")
    public DeferredResult<Object> createOrder(){
        DeferredResult<Object> result = new DeferredResult<Object>((long)3000,"create fail...");
        DefferedQueue.save(result);
        return result;
    }

    @ResponseBody
    @RequestMapping("/create")
    public String create(){
        DeferredResult<Object> deferredResult = DefferedQueue.get();
        deferredResult.setResult("creating...");
        return deferredResult.getResult().toString();
    }
}
