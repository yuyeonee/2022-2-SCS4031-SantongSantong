from channels.routing import ProtocolTypeRouter, URLRouter
import models.routing

application = ProtocolTypeRouter({
    # (http->django views is added by default)
    'websocket': URLRouter(
        models.routing.websocket_urlpatterns
    )
})