from datetime import timezone
from pathlib import Path
from django.shortcuts import render
from backend.models.models import Drowning

# Create your views here.
def create():
    file_path = Path("./static/drowning.jpg")
    if file_path.exists():
        new_drowning = Drowning()
        new_drowning.id = 1
        new_drowning.pub_date = timezone.now()
        new_drowning.image = "./static/drowning.jpg"
