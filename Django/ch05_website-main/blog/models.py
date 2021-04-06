from django.db import models
from django.contrib.auth.models import User


class Post(models.Model):
    title = models.CharField(max_length=30)
    content = models.TextField()
    created = models.DateTimeField(blank=True)
    author = models.ForeignKey(User, models.CASCADE)
    head_image = models.ImageField(upload_to='blog/%Y/%m/%d/', blank=True)

    def __str__(self):
        return "{} :: {}".format(self.title, self.author)
