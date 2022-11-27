from datetime import timezone
from pathlib import Path
from django.shortcuts import render

# Create your views here.
# def create():
#     file_path = Path("./static/drowning.jpg")
#     if file_path.exists():
#         new_drowning = Notification()
#         new_drowning.id = 1
#         new_drowning.pub_date = timezone.now()
#         new_drowning.image = "./static/drowning.jpg"


def index(request):
    return render(request, "models/index.html")

def area(request, area_name):
    return render(request, "models/notification.html", {"area_name": area_name})