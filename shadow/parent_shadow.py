# This is the parent shadow file, which will launch shadow.py as a thread, so that it is possible to
# kill and restart the process as a thread. The parent-shadow will always be executing.

import threading as Threading;
import shadow;

