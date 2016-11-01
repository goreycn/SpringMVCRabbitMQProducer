package ctrl;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexCtrl {

    @Autowired
    RabbitTemplate rabbitTemplate;


    @RequestMapping("/")
    @ResponseBody
    public String index(){
        return "hello";
    }

    @RequestMapping("/add/{abc}")
    @ResponseBody
    public String add(@PathVariable(value = "abc") String abc){

        rabbitTemplate.convertAndSend("spring-boot", abc + " from RabbitMQ!");

        return "man";
    }
}
