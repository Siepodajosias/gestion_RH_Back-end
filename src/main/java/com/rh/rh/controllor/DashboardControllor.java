package com.rh.rh.controllor;

import com.rh.rh.facade.DashoardFacade;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardControllor {
    private final DashoardFacade dashoardFacade;

    public DashboardControllor(DashoardFacade dashoardFacade) {
        this.dashoardFacade = dashoardFacade;
    }
}
