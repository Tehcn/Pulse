package dev.tehcn.pulse.event;

import dev.tehcn.pulse.Pulse;
import net.minecraft.util.crash.CrashException;
import net.minecraft.util.crash.CrashReport;
import net.minecraft.util.crash.CrashReportSection;

import java.util.*;

public class EventManager {
    private final HashMap<Class<? extends Listener>, ArrayList<? extends Listener>> listenerMap = new HashMap<>();

    public EventManager() { }

    public static<L extends Listener, E extends Event<L>> void fire(E e) {
        EventManager eventManager = Pulse.INSTANCE.eventManager;
        if(eventManager == null) return;
        eventManager.fireImpl(e);
    }

    private <L extends Listener, E extends Event<L>> void fireImpl(E event) {
        try {
            Class<L> type = event.getListenerType();

            @SuppressWarnings("unchecked")
            ArrayList<L> listeners = (ArrayList<L>) listenerMap.get(type);

            if(listeners == null || listeners.isEmpty()) return;

            ArrayList<L> listenersCopy = new ArrayList<>(listeners);
            listenersCopy.removeIf(Objects::isNull);
            event.fire(listenersCopy);

        } catch(Throwable e) {
            e.printStackTrace();

            CrashReport report = CrashReport.create(e, "Firing Pulse Event");
            CrashReportSection section = report.addElement("Event");
            section.add("Class", () -> event.getClass().getName());

            throw new CrashException(report);
        }
    }

    public <L extends Listener> void add(Class<L> type, L listener)
    {
        try
        {
            @SuppressWarnings("unchecked")
            ArrayList<L> listeners = (ArrayList<L>)listenerMap.get(type);

            if(listeners == null)
            {
                listeners = new ArrayList<>(List.of(listener));
                listenerMap.put(type, listeners);
                return;
            }

            listeners.add(listener);

        }catch(Throwable e)
        {
            e.printStackTrace();

            CrashReport report =
                    CrashReport.create(e, "Adding Pulse Event Listener");
            CrashReportSection section = report.addElement("Listener");
            section.add("Type", type::getName);
            section.add("Class", () -> listener.getClass().getName());

            throw new CrashException(report);
        }
    }

    public <L extends Listener> void remove(Class<L> type, L listener)
    {
        try
        {
            @SuppressWarnings("unchecked")
            ArrayList<L> listeners = (ArrayList<L>)listenerMap.get(type);

            if(listeners != null)
                listeners.remove(listener);

        }catch(Throwable e)
        {
            e.printStackTrace();

            CrashReport report = CrashReport.create(e, "Removing Pulse Event Listener");
            CrashReportSection section = report.addElement("Listener");
            section.add("Type", type::getName);
            section.add("Class", () -> listener.getClass().getName());

            throw new CrashException(report);
        }
    }
}
