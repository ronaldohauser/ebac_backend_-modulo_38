package com.exemplo.meuprojeto.service;

import com.exemplo.meuprojeto.model.User;
import com.exemplo.meuprojeto.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    public UserServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() {
        when(userRepository.findAll()).thenReturn(Arrays.asList(new User(1L, "John Doe")));

        assertEquals(1, userService.findAll().size());
        verify(userRepository, times(1)).findAll();
    }

    @Test
    public void testFindById() {
        User user = new User(1L, "John Doe");

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        assertEquals("John Doe", userService.findById(1L).get().getName());
        verify(userRepository, times(1)).findById(1L);
    }

    @Test
    public void testSave() {
        User user = new User(null, "John Doe");

        when(userRepository.save(user)).thenReturn(user);

        assertEquals("John Doe", userService.save(user).getName());
        verify(userRepository, times(1)).save(user);
    }

    @Test
    public void testDelete() {
        userService.delete(1L);
        verify(userRepository, times(1)).deleteById(1L);
    }
}
