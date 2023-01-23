package com.miniProject.authApp.services;

import com.miniProject.authApp.domain.SignUpData;
import com.miniProject.authApp.domain.User;
import com.miniProject.authApp.domain.UserDTO;
import com.miniProject.authApp.proxy.IUserProxy;
import com.miniProject.authApp.rabbitmq.EmailDTO;
import com.miniProject.authApp.rabbitmq.MailProducer;
import com.miniProject.authApp.repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CService implements IService{
    @Autowired
    private IRepository iRepository;

    @Autowired
    private IUserProxy iUserProxy;

    @Autowired
    private MailProducer mailProducer;

    @Override
    public User register(SignUpData signUpData) {
        iUserProxy.sendDTOToUserApp(new UserDTO(signUpData.getEmail(), signUpData.getName()));
        User user=iRepository.save(new User(signUpData.getEmail(), signUpData.getPassword(),"USER" ));
        mailProducer.sendEmailToQueue(new EmailDTO(user.getEmail(), "We Welcome You to Our Site ","Registered Successfully"));
        return user;
    }

    @Override
    public User login(User user) {
        return iRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
    }

    @Override
    public void deleteUser(String email) {
        iRepository.deleteById(email);
    }
}
