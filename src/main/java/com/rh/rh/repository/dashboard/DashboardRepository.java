package com.rh.rh.repository.dashboard;

import com.rh.rh.entity.Dashboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DashboardRepository extends JpaRepository <Dashboard, Long> {
}
