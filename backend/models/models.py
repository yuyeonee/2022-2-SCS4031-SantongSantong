from django.db import models
import os

# Create your models here.
class Notification(models.Model):
    id = models.IntegerField
    pub_date = models.DateTimeField
    image = models.ImageField(blank=True, null=True)
