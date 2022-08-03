package dev.tehcn.pulse.event.listeners;

import dev.tehcn.pulse.event.CancellableEvent;
import dev.tehcn.pulse.event.Listener;

import java.util.ArrayList;

public interface LeftClickListener extends Listener
{
    void onLeftClick(LeftClickEvent event);

    class LeftClickEvent
            extends CancellableEvent<LeftClickListener>
    {
        @Override
        public void fire(ArrayList<LeftClickListener> listeners)
        {
            for(LeftClickListener listener : listeners)
            {
                listener.onLeftClick(this);

                if(isCancelled())
                    break;
            }
        }

        @Override
        public Class<LeftClickListener> getListenerType()
        {
            return LeftClickListener.class;
        }
    }
}
