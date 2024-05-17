from typing import Generic, TypeVar

# Define a type variable
T = TypeVar("T")


# Define a generic class
class GenericBox(Generic[T]):
    def __init__(self):
        self._t = None

    def set(self, t: T):
        self._t = t

    def get(self) -> T:
        return self._t
