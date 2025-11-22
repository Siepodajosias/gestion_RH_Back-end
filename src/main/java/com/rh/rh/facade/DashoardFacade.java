package com.rh.rh.facade;

import com.rh.rh.repository.dashboard.DashboardRepository;
import org.springframework.stereotype.Service;

@Service
public class DashoardFacade {
    private final DashboardRepository dashboardRepository;

    public DashoardFacade(DashboardRepository dashboardRepository) {
        this.dashboardRepository = dashboardRepository;
    }
}
