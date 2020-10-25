package com.gbf.testcontainer.repo;

import com.gbf.testcontainer.model.User;
import org.springframework.data.repository.CrudRepository;

public interface Repo extends CrudRepository<User, Long> {
}
