package com.zx.service;

import com.zx.model.Message;
import com.zx.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by 11790 on 2019/2/24.
 */
@Service("messageRepository")
public class InMemoryMessageRepository  implements MessageRepository {
    private static AtomicLong counter=new AtomicLong();
    private final ConcurrentMap<Long,Message> messages=new ConcurrentHashMap<Long,Message>();

    @Override
    public List<Message> findAll() {
        List<Message> messages=new ArrayList<Message>(this.messages.values());
        return messages;
    }

    @Override
    public Message save(Message message) {
        Long id = message.getId();
        if (id == null) {
            id = counter.incrementAndGet();
            message.setId(id);
        }
        this.messages.put(id, message);
        return message;
    }

    @Override
    public Message update(Message message) {
        this.messages.put(message.getId(), message);
        return message;
    }

    @Override
    public Message updateText(Message message) {
        Message msg=this.messages.get(message.getId());
        msg.setText(message.getText());
        this.messages.put(msg.getId(), msg);
        return msg;
    }

    @Override
    public Message findMessage(Long id) {
        return this.messages.get(id);
    }

    @Override
    public void deleteMessage(Long id) {
        this.messages.remove(id);
    }
}
