# This is the parent shadow file, which will launch shadow.py as a thread, so that it is possible to
# kill and restart the process as a thread. The parent-shadow will always be executing.
# Based on the features that shadow is going to implement, when a restart is happening, the neural
# networks are to be trained again, so the training set is to be made available and we need to give
# some time for the whole training process to complete.

# The training set for a restart can be formed from including both base training set and the real
# time commands served so far.

int main() {
    shadow_main();
}
