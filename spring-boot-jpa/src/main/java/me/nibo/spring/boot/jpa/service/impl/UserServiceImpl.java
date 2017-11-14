package me.nibo.spring.boot.jpa.service.impl;

import me.nibo.spring.boot.jpa.domain.User;
import me.nibo.spring.boot.jpa.repository.UserRepository;
import me.nibo.spring.boot.jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
    class UserServiceImpl implements UserService {

        @Autowired
        private UserRepository userRepository;

        @Override
        public User findByName(String name) {
            return userRepository.findByName(name);
        }

        @Override
        public Page<User> findByNameLike(String name, Pageable pageable) {
            return userRepository.findByNameLike(name, pageable);
        }

        @Override
        public User findByNameAndAge(String name, Integer age) {
            return userRepository.findByNameAndAge(name, age);
        }

        @Override
        public List<User> findUser(String name, int age) {
            return userRepository.findUser(name, age);
        }

        @Override
        public User save(User user) {
            return userRepository.save(user);
        }

        @Override
        public User update(User user) {
            return userRepository.saveAndFlush(user);
        }
    }