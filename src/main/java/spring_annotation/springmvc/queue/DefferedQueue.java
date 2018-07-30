package spring_annotation.springmvc.queue;

import org.springframework.web.context.request.async.DeferredResult;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class DefferedQueue{
    private static Queue<DeferredResult<Object>> queue = new ConcurrentLinkedQueue<DeferredResult<Object>>();

    public static void save(DeferredResult<Object> result){
        queue.add(result);
    }

    public static DeferredResult<Object> get(){
       return queue.poll();
    }
}
