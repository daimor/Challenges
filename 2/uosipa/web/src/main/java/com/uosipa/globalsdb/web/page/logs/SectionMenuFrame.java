package com.uosipa.globalsdb.web.page.logs;

import com.uosipa.globalsdb.model.Service;
import com.uosipa.globalsdb.web.page.frame.ApplicationFrame;
import org.nocturne.link.Links;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Dmitry Levshunov (levshunov.d@gmail.com)
 */
class SectionMenuFrame extends ApplicationFrame {
    private Service currentService;

    public SectionMenuFrame(Service currentService) {
        this.currentService = currentService;
    }

    @Override
    public void action() {
        Collection<Link> links = new ArrayList<Link>();

        Service[] services = Service.values();
        for (Service service : services) {
            links.add(new Link(
                    Links.getLink(LogsPage.class, "service", service),
                    $(service.toString()),
                    service == currentService
            ));
        }

        put("links", links);
    }
}
