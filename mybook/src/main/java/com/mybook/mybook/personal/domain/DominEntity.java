package com.mybook.mybook.personal.domain;

import org.springframework.data.domain.Persistable;

import java.io.Serializable;

public interface DominEntity extends Serializable, Persistable<Long> {
}
