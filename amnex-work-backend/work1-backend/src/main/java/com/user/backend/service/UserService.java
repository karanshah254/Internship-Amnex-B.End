package com.user.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.user.backend.entity.User;
import com.user.backend.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User addUser(User user) {
		List<User> existingUsers = userRepository.findAll();

		int nextSrNo = existingUsers.size() + 1; // Auto-increment srNo
		user.setSrNo(nextSrNo);
		return userRepository.save(user);
	}

	public List<User> addUsers(List<User> users) {
		int nextSrNo = (int) (userRepository.count() + 1);

		for (User user : users) {
			user.setSrNo(nextSrNo++);
		}

		return userRepository.saveAll(users);
	}

	public User updatedUser(int srNo, User updatedUser) {
		List<User> users = userRepository.findAll();

		for (User user : users) {
			if (user.getSrNo() == srNo) {
				user.setName(updatedUser.getName());
				user.setGender(updatedUser.getGender());
				user.setDob(updatedUser.getDob());
				user.setPincode(updatedUser.getPincode());

				return userRepository.save(user); // Save updated user
			}
		}
		return null;
	}

	@Transactional
	public void deleteUser(int srno) {
		userRepository.deleteBySrNo(srno);
		resetSrNumber();
	}

	public void resetSrNumber() {
		List<User> users = userRepository.findAll();
		for (int i = 0; i < users.size(); i++) {
			users.get(i).setSrNo(i + 1); // Reset srNo in sequence
			userRepository.save(users.get(i));
		}
	}
}
