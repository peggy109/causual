import handle_cfg
import sys
cfg = sys.argv[1];
section = sys.argv[2];
key = sys.argv[3];
val = handle_cfg.get_config_val(cfg, section, key);
print val