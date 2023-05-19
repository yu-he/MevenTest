package InfoSky;

import com.pantech.esb.bean.ResultMessage;
import com.pantech.esb.service.MessageSenderProcess;

class SenderService implements MessageSenderProcess {
    @Override
    public void senderProcess(ResultMessage resultMessage) {
        if (resultMessage.isOk()) {
            // 消息推送成功
        } else {
            // 消息推送失败
        }
    }
}
