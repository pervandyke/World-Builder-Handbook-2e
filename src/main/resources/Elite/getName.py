import pyplanets
import random

galaxy = pyplanets.Galaxy()
print(random.choice(galaxy.planets), end='')