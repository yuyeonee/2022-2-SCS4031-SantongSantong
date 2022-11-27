from django.urls import re_path

from . import consumers

websocket_urlpatterns = [
    re_path(
        r"ws/models/(?P<area_name>\w+)/$",
        consumers.NotificationConsumer.as_asgi(),
    ),
]
