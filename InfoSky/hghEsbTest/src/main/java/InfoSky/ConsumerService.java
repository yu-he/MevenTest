package InfoSky;

import com.pantech.esb.bean.ResultMessage;
import com.pantech.esb.service.MessageConsumerProcess;

class ConsumerService implements MessageConsumerProcess {
    @Override
    public ResultMessage process(String o) {
        String name = Thread.currentThread().getName();
        System.out.println(name + " " + o);
        return ResultMessage.ok();
    }
}
