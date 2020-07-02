package com.dao;

import com.damain.Emp;

public interface ILoginDao {
    Emp verify(String username);
}
